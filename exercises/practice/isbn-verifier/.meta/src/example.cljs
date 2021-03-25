(ns isbn-verifier)

(defn- error-checker-fn
  "Check the ISBN data structure against any invalidate status and if it is, do not call the function.
   Some kinda high order fail-safe function. For Forward-Reading, look at Railway oriented programming."
  [f {validation :validation :as isbn}]
  (if validation
    (f isbn)
    isbn))

(defn- init-isbn10-d
  "Takes ISBN-10 string and initialize the structure of the exercise logic."
  [isbn10]
  {:isbn isbn10 :validation true})

(defn- isbn10-count-validation*
  "Check the ISBN10 character count against any invalid string.
   If there is any invalid situation, set the :validation flag `false`"
  [isbn]
  (if (or
       (-> isbn :isbn count (< 9))
       (-> isbn :isbn count (> 13)))
    (assoc-in isbn [:validation] false)
    isbn))

(def isbn10-count-validation
  "ISBN10 count function combined with fail-safe function wrapper."
  (partial error-checker-fn isbn10-count-validation*))

(defn- isbn10-X-validator*
  "Takes ISBN structure and check the last character of it.
   If it is `X` character:
   - Set the calculated total value with summed with ten.
   If not:
   - Do not change anything."
  [{isbn :isbn :as isbn10}]
  (if (-> isbn last (= \X))
    (update-in isbn10 [:calculated-tot] + 10)
    isbn10))

(def isbn10-X-validator
  "ISBN10 X validator function combined with fail-safe function wrapper."
  (partial error-checker-fn isbn10-X-validator*))

(defn- isbn10-number-sequences*
  "Generate ISBN10 number sequence for the calculation."
  [{isbn :isbn :as isbn10}]
  (assoc-in isbn10 [:isbn10-sequence] (vec (map int (re-seq #"\d" isbn)))))

(def isbn10-number-sequences
  "ISBN10 number sequence function combined with fail-safe function wrapper."
  (partial error-checker-fn isbn10-number-sequences*))

(defn- isbn10-calculate-value*
  "ISBN10 calculate the desired value and assoc it to the structure."
  [{isbn-sq :isbn10-sequence :as isbn10}]
  (let [middle-calc (reverse (range 1 11))
        calculated-formula (map * isbn-sq middle-calc)
        final-calculation (reduce + calculated-formula)]
    (-> isbn10
        (assoc-in [:calculated-tot] final-calculation))))

(def isbn10-calculate-value
  "ISBN10 calculate value function combined with fail-safe function wrapper."
  (partial error-checker-fn isbn10-calculate-value*))

(defn- isbn10-calculated-validation*
  "ISBN10 calculate final validation result based on the calculated total value."
  [{ct :calculated-tot :as isbn10}]
  (if (zero? (mod ct 11))
    isbn10
    (assoc-in isbn10 [:validation] false)))

(def isbn10-calculated-validation
  "ISBN10 calculate final validation function combined with fail-safe function wrapper."
  (partial error-checker-fn isbn10-calculated-validation*))

(defn- isbn10-validate
  "A simple value extractor from the ISBN structure."
  [{validation :validation}]
  validation)

(defn isbn?
  "isbn? is the final and composed function with all our simple and tiny logics on data."
  [isbn]
  (-> isbn
      init-isbn10-d
      isbn10-count-validation
      isbn10-number-sequences
      isbn10-calculate-value
      isbn10-X-validator
      isbn10-calculated-validation
      isbn10-validate))
