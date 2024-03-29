<header>
    <h1>Welcome to YARGA!</h1>
    <h2><i>Yet Another Random Generator API</i></h2>
    <h4>Robert Sharp</h4>
</header>
<section>
    <article>
    <h3>Abstract</h3>
    <p>YARGA provides convenient access to high-performance thread local random value generators via its friendly API.
    This codebase is intended to be used as an introductory teaching tool and may not represent current best practices.
    For private use only, use with caution and void where prohibited!</p>
    <p><b>Warning: The underlying random engine is not cryptographically secure and should not be used for security or secure hashing.</b></p>
    </article>
    <article>
    <h3>YARGA Tech Stack</h3>
    <ul>
        <li>RNG Engine: Fortuna for Java</li>
        <li>Kotlin: JVM (Java 11)</li>
        <li>Spring Boot: Maven</li>
        <li>AWS: Elastic Beanstalk - Corretto 11</li>
    </ul>
    </article>
    <article>
    <h3>YARGA Endpoints</h3>
    <h4>Canonical</h4>
    <ul>
        <li>Canonical() -> Double</li>
        <li>Returns a random double precision floating point value</li>
        <li>Distribution: Flat Uniform => Range[0.0..1.0) *tail exclusive</li>
        <li>Method: GET</li>
        <li>Response: JSON</li>
    </ul>
    <h4>One Die Roll</h4>
    <ul>
        <li>Die(sides: Int) -> Int</li>
        <li>Returns a random integer</li>
        <li>Distribution: Flat Uniform => Range[1..sides] *inclusive</li>
        <li>Method: GET</li>
        <li>Param `sides`: Size of die to be rolled. Default: 6</li>
        <li>Response: JSON</li>
    </ul>
    <h4>Multi Dice Roll</h4>
    <ul>
        <li>Dice(rolls: Int sides: Int) -> Int</li>
        <li>Returns a random integer</li>
        <li>Distribution: Middle Geometric => Range[rolls..rolls*sides] *inclusive</li>
        <li>Method: GET</li>
        <li>Param `rolls`: Number of dice to be rolled. Default: 1</li>
        <li>Param `sides`: Size of dice to be rolled. Default: 20</li>
        <li>Response: JSON</li>
    </ul>
    <h4>Percent True</h4>
    <ul>
        <li>PercentTrue(chance: Int) -> Bool</li>
        <li>Returns a random boolean</li>
        <li>Distribution: Linear => Literal[true, false]</li>
        <li>Method: GET</li>
        <li>Param `chance`: Percent chance of returning true. Default: 50</li>
        <li>Response: JSON</li>
    </ul>
    </article>
</section>
