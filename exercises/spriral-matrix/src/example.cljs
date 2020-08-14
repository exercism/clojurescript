(ns ^{:doc "This solution referenced from `RosettaCode` [https://rosettacode.org/wiki/Spiral_matrix#Clojure]"}
    spiral-matrix)

(defn spiral-matrix [m n & [start]]
  (if (= 0 n m)
    '()
    (let [row (list (map #(+ start %) (range m)))]
      (if (= 1 n) row
          (concat row (map reverse
                           (apply map list
                                  (spiral-matrix (dec n) m (+ start m)))))))))

(defn spiral [n] (spiral-matrix n n 1))
