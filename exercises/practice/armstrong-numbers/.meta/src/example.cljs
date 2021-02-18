(ns armstrong-numbers
  (:require [cljs.reader]))

(defn- expt [base pow]
  (reduce * 1 (repeat pow base)))

(defn armstrong? [n]
  (let [digits (map (comp float str) (str n))
        l      (count digits)]
    (= (reduce + (map #(Math/pow % l) digits))
       n)))
