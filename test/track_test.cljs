(ns track-test
  (:require [cljs.test :refer [deftest testing is] :include-macros true]))

(deftest track-general-test
  (testing "Track general tests are running..."
    (let [track-general-tests (constantly true)]
      (is (= (track-general-tests)
             true)))))
