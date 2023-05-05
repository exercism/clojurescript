# Tests

To use the CLI to run the exercise's test, run the following command from the exercise's directory:

```bash
clojure -M:test
```

## REPL

To use the REPL to run the exercise's test, run the following command from the exercise's directory:

```bash
$ clojure -m cljs.main -re node
```

Then `require` the exercise's test namespace and the Clojure test namespace):

```clojure
;; replace <exercise> with the exercise's name
=> (require '<exercise>-test)
nil
;; and the test namespace
=> (require 'cljs.test)
```

Change the ns to the test namespace:

```clojure
;; replace <exercise> with the exercise's name
=> (ns <exercise>-test)
nil
```

Then call `run-tests`:

```clojure
=> (cljs.test/run-tests)
```
