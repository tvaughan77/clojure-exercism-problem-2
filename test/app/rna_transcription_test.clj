(ns app.rna-transcription-test
  (:require [clojure.test :refer :all]
            [app.rna_transcription :refer :all]))

(deftest transcribes-cytosine-to-guanine
  (is (= "G" (app.rna_transcription/to-rna "C"))))

(deftest transcribes-guanine-to-cytosine
  (is (= "C" (app.rna_transcription/to-rna "G"))))

(deftest transcribes-adenine-to-uracil
  (is (= "U" (app.rna_transcription/to-rna "A"))))

(deftest it-transcribes-thymine-to-adenine
  (is (= "A" (app.rna_transcription/to-rna "T"))))

(deftest it-transcribes-all-nucleotides
  (is (= "UGCACCAGAAUU" (app.rna_transcription/to-rna "ACGTGGTCTTAA"))))

(deftest it-validates-dna-strands
  (is (thrown? AssertionError (app.rna_transcription/to-rna "XCGFGGTDTTAA"))))

(run-tests)
