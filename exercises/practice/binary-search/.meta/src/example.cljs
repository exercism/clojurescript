(ns binary-search)

(defn- flip-kv [v]
  (into {} (map vector (vals v) (keys v))))

(defn- throw-nf [value]
  (if value value (throw (new js/Error "not found"))))

(defn search-for [e v]
  (throw-nf (get (flip-kv (into {} (map-indexed vector v))) e)))

(defn middle [v]
  (-> v count (quot 2)))
