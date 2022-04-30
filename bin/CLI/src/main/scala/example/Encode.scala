package example

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.io.IOException;
import java.security.KeyPair;
import javax.xml.bind.DatatypeConverter;

class Encode {

  val argon2 = Argon2Factory.create();

  val encryption = new Encryption()

  @throws(classOf[Exception])
  def encrypt(plainText: String): String = encryption.encryptPasswordBased(plainText);

  @throws(classOf[Exception])
  def decrypt(cipherText: String): String = encryption.decryptPasswordBased(cipherText);

  def hashpw(pass: String): String = {

    val passwordChars = pass.toCharArray();

    val stored = argon2.hash(22, 65536, 1, passwordChars);

    argon2.wipeArray(passwordChars);

    try {

      return encrypt(stored);

    } catch {
      case e: Exception => {

      return "";
      }
    }
  }

  def verify(pass :String, hash: String): Boolean = {
      try{

        val newHash = decrypt(hash);

        return argon2.verify(newHash, pass.toCharArray());

    } catch {
      case e: Exception => {
        return false;
      }
    }
  }
}
