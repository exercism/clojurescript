(ns rna-transcription-test
  (:require [cljs.test :as t :include-macros true]
            rna-transcription))

(t/deftest transcribes-cytosine-to-guanine
  (t/testing "Transcribes Cytosine to Guanine..."
    (t/is (= "G" (rna-transcription/to-rna "C")))))

(t/deftest transcribes-guanine-to-cytosine
  (t/testing "Transcribes Guanine to Cytosine..."
    (t/is (= "C" (rna-transcription/to-rna "G")))))

(t/deftest transcribes-adenine-to-uracil
  (t/testing "Transcribes Adenine to Uracil..."
    (t/is (= "U" (rna-transcription/to-rna "A")))))

(t/deftest transcribes-thymine-to-adenine
  (t/testing "Transcribes Tymine to Adenine..."
    (t/is (= "A" (rna-transcription/to-rna "T")))))

(t/deftest transcribes-all-nucleotides
  (t/testing "Transcribes all nucleotides..."
    (t/is (= "UGCACCAGAAUU" (rna-transcription/to-rna "ACGTGGTCTTAA")))))

(t/deftest validates-dna-strands
  (t/testing "Transcribes DNA Strands..."
    (t/is (thrown? js/Error (rna-transcription/to-rna "XCGFGGTDTTAA")))))
