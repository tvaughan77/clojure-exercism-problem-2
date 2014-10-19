(ns app.rna_transcription
    (:gen-class))

; Probably a better map-based way of doing this
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

(defn to-rna [sequence]
  (apply str (to-rna-internal (map str sequence))))


