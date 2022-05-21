package com.rest.diceapi

const val homepage: String = """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>YARGA</title>
    <style>
        :root {
            color-scheme: dark;
        }

        body {
            margin: 40px;
        }
        section {
            max-width: 900px;
        }
        header {
            margin-bottom: 60px;
        }
        article {
            margin-top: 40px;
        }
    </style>
</head>
<body>
<section>
    <header>
    <h1>Welcome to YARGA!</h1>
    <h2><i>Yet Another Random Generator API</i></h2>
    <h4>Bloom Institute of Technology<br>Robert Sharp, Data Science Manager</h4>
    </header>
    <article>
    <h3>Abstract</h3>
    <p>YARGA provides convenient access to high-performance thread local random value generators via its friendly API.
    This codebase is intended to be used as a introductory teaching tool and may not represent current best practices.
    For private use only, use with cation!</p>
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
        <li>Example: <a href="/canonical">/canonical</a></li>
    </ul>
    <h4>One Die Roll</h4>
    <ul>
        <li>Die(sides: Int) -> Int</li>
        <li>Returns a random integer</li>
        <li>Distribution: Flat Uniform => Range[1..sides] *inclusive</li>
        <li>Method: GET</li>
        <li>Param `sides`: Size of die to be rolled. Default: 6</li>
        <li>Response: JSON</li>
        <li>Example d12: <a href="/die?sides=12">/die?sides=12</a></li>
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
        <li>Example 8d6: <a href="/dice?rolls=8&sides=6">/dice?rolls=8&sides=6</a></li>
    </ul>
    <h4>Percent True</h4>
    <ul>
        <li>PercentTrue(chance: Int) -> Bool</li>
        <li>Returns a random boolean</li>
        <li>Distribution: Linear => Literal[true false]</li>
        <li>Method: GET</li>
        <li>Param `chance`: Percent chance of returning true. Default: 50</li>
        <li>Response: JSON</li>
        <li>Example 75%: <a href="/percent-true?chance=75">/percent-true?chance=75</a></li>
    </ul>
    </article>
</section>
</body>
</html>"""