(ns hamming)

(defn distance
  "Hamming, DNA strands a and b."
  [a b]
  (let [a-count (count a)
        b-count (count b)]
    (when (= a-count b-count)
      (count (filter identity (map not= a b))))))
