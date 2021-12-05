# Vision Subsystem

Provides a stateless interface VisionProvider for access to functionality.
Decorator interfaces handle specific functionality such as invalidating cached values.
Should be functionally similar and compatible with 2020's VisionSystem without the 
statefulness and weak points

# The doctrine known as EOS-P

EOS-P stands for Elegant Objects - SolarMC Combined Programming Paradigm.
It is a style of code that incorporates everything i've learned from every website and project i've worked on. 
It is in no way complete and in no way 100% correct, but it is my preference.
I do not want to betray the constitution's programming paradigm or FRC codestyle (I'll call it FRC-P)
but I would rather use EOS-P as it avoids bugs and timewasting "magic" code
by design.

**Some interesting rules of EOS-P**

1. A Minimum Viable Project is more important than maintainability.
2. Maintainability is more important than performance.
3. Performance is more important than simplicity.
4. Code should be stateless and immutable by default. Mutability is weakness, especially when working with concurrent programming
5. Static methods are evil (and as an extension, factories are evil).
6. Constants are evil.
7. "Configuration" classes are, for the most part, evil.
8. Everything you know and love is evil.
9. Data should be shared through dependency injection (final variable instances passed through the constructor) and not static or public variables.
10. Code is not placed in the constructor besides code used to define final variables. Any initialization code is to be done via a method, since constructors are not meant for functionality. Half of FRC's libraries betray this.
11. Interfaces are contracts.
12. Every functionality should be defined by a contract.
13. Interfaces are always preferable to abstract classes. Not only do they hide implementation details, they allow for decorator functionality and code readability and comprehension. 
14. Code should be truly object oriented. The functionality of a class should be small, handling one or two features.
15. As a result of this, classes should have no more than 4 parameters in a method (including the constructor). Any more means that your class is handling too much functionality.
16. Classes should generally not extend 100-200 lines.
17. Classes (even implementing a contract) should not duplicate functionality. A KeyLimelightProvider and KeyDatasourceProvider are easily replaced by a single class KeyProvider with a parameter for which table to query.
18. Quality is generally preferable to unquality.
19. EOS-P is never always correct.

Of course, i break these rules in Vision Subsystem, because completely eos-p code surrounded by frc-p code sticks out and 
confuses developers. However, Vision Subsystem demonstrates an attempt to at least adhere to some of these rules to ensure 
maintainable, quality code.