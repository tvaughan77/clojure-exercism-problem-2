(ns app.rna_transcription
    (:gen-class))

(defn base-pair [nucleotide]
    (cond
        (= "A" nucleotide) "U"
        (= "T" nucleotide) "A"
        (= "C" nucleotide) "G"
        (= "G" nucleotide) "C"
        :else (throw (AssertionError. (str "Expected one of A, T, C or G, but was " nucleotide)))))

(defn to-rna-internal [sequence]
    (cond
        (empty? sequence) nil
        :else (cons (base-pair (first sequence)) (to-rna-internal (rest sequence)))))

(defn make-str-from-chars
  "make a string from a sequence of characters"
  [chars]
  (reduce str "" chars))

(defn to-rna [sequence]
    (make-str-from-chars (to-rna-internal (.split sequence "(?!^)"))))



