; Courtesy from: https://exercism.org/tracks/clojure/exercises/atbash-cipher/solutions/joebutler2

(ns atbash-cipher
  (:require [clojure.string :as str]))

(def translation
  {
   "a" "z"
   "b" "y"
   "c" "x"
   "d" "w"
   "e" "v"
   "f" "u"
   "g" "t"
   "h" "s"
   "i" "r"
   "j" "q"
   "k" "p"
   "l" "o"
   "m" "n"
   "n" "m"
   "o" "l"
   "p" "k"
   "q" "j"
   "r" "i"
   "s" "h"
   "t" "g"
   "u" "f"
   "v" "e"
   "w" "d"
   "x" "c"
   "y" "b"
   "z" "a"
})

(defn encode [input]
  (->> input
       (str/lower-case)
       (re-seq #"\w|\d")
       (map #(get translation % %))
       (partition-all 5)
       (map #(cons %2 %) (repeat " "))
       (flatten)
       (str/join)
       (str/trimr)))
