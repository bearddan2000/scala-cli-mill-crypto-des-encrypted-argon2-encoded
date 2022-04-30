import mill._, scalalib._

// `HelloWorld` must match the subdirectory name
object CLI extends ScalaModule {
    def scalaVersion = "2.13.1"

    def ivyDeps = Agg(
      ivy"javax.xml.bind:jaxb-api:2.3.1",
      ivy"de.mkammerer:argon2-jvm:2.7"
    )
}
