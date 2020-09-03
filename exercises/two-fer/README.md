# Two Fer

`Two-fer` or `2-fer` is short for two for one. One for you and one for me.

Given a name, return a string with the message:

```text
One for S, one for me.
```

Where S is the given name.

However, if the name is missing, return the string:

```text
One for you, one for me.
```

Here are some examples:

|Name    | String to return 
|:------:|:-----------------: 
|Sarah   | One for Sarah, one for me.
|Alice   | One for Alice, one for me. 
|Eric    | One for Eric, one for me.
|        | One for you, one for me.

### Running tests

Run the tests using `clj -A:test` command and make them pass:

```
$ clj -A:test

Testing hello-world-test

Ran 1 tests containing 1 assertions.
0 failures, 0 errors.
```

### Submitting Source

Then submit the exercise using:

```
$ exercism submit src/two_fer.clj
```

For more detailed instructions and learning resources refer [Exercism's Clojurescript Language Page](http://exercism.io/languages/clojurescript).

## Source

[https://github.com/exercism/problem-specifications/issues/757](https://github.com/exercism/problem-specifications/issues/757)

## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have completed the exercise.
