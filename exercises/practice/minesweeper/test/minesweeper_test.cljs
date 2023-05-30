(ns minesweeper-test
  (:require [cljs.test :refer [deftest is] :as t :include-macros true]
            [clojure.string :refer [join]]
            [minesweeper :refer [draw]]))

(def line-separator "\n")

(deftest zero-size-board
  (is (= (draw "") "")))

(deftest empty-board
  (is (= (draw (join line-separator ["   "
                                     "   "
                                     "   "]))
         (join line-separator ["   "
                               "   "
                               "   "]))))

(deftest surrounded
  (is (= (draw (join line-separator ["***"
                                     "* *"
                                     "***"]))
         (join line-separator ["***"
                               "*8*"
                               "***"]))))

(deftest board-full-of-mines
  (is (= (draw (join line-separator ["***"
                                     "***"
                                     "***"]))
         (join line-separator ["***"
                               "***"
                               "***"]))))

(deftest horizontal-line
  (is (= (draw " * * ")
         "1*2*1")))

(deftest vertical-line
  (is (= (draw (join line-separator [" "
                                     "*"
                                     " "
                                     "*"
                                     " "]))
         (join line-separator ["1"
                               "*"
                               "2"
                               "*"
                               "1"]))))

(deftest cross
  (is (= (draw (join line-separator ["  *  "
                                     "  *  "
                                     "*****"
                                     "  *  "
                                     "  *  "]))
         (join line-separator [" 2*2 "
                               "25*52"
                               "*****"
                               "25*52"
                               " 2*2 "]))))
