package essentialScala.Functions

// If Result of type A is a Success or Failure:
sealed trait Result[A]
final case class Success[A](result: A) extends Result[A]
final case class Failure[A](reason: String) extends Result[A]