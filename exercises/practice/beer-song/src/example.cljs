(ns beer-song
  (:require [clojure.string]
            [goog.string]
            [goog.string.format]))

(defn- n-bottles-beer
  "Takes bottle number and returns part of the lyrics;
  `n bottles of beer`"
  [^Integer n]
  (condp = n
        0 "no more bottles of beer"
        1 (goog.string/format "%d bottle of beer" n)
        (goog.string/format "%d bottles of beer" n)))

(defn- first-line
  "Takes bottle number and returns first line of the lyrics."
  [^Integer n]
  (clojure.string/capitalize (apply goog.string/format "%1s on the wall, %1s.\n" (repeat 2 (n-bottles-beer n)))))

(defn- take-it-down
  "Takes bottle number and returns part of the lyrics;
  `Take it down and pass it around, n bottle(s) of beer on the wall.\n`"
  [^Integer n]
  (condp = n
    0 (goog.string/format "Go to the store and buy some more, %s on the wall.\n" (n-bottles-beer 99))
    1 (goog.string/format "Take it down and pass it around, %s on the wall.\n" (n-bottles-beer 0))
    (goog.string/format "Take one down and pass it around, %s on the wall.\n" (n-bottles-beer (dec n)))))

(defn verse
  "Takes bottle number and returns verse."
  ([n]
   (str (first-line n)
        (take-it-down n)))
  ([n t]
   (let [verse-to (range n (dec t) -1)
         verses (map #(str (first-line %) (take-it-down %)) verse-to)]
     (clojure.string/join "\n" verses))))

(defn sing
  "Gate for the verse function as test file forced..."
  ([n t]
   (verse n t))
  ([n]
   (verse n 0)))
