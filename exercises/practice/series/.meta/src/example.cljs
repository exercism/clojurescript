(ns series)

(defn slices
  "Takes an ^String s ^Integer n.
   Checks it agains zero? or greater than s's count.
   If it pass, returns slices."
  [s n]
  (let [str-count (count s)]
    (cond
      (zero? n) [""]
      (> n str-count) []
      :else (map #(apply str %) (partition n 1 s)))))
