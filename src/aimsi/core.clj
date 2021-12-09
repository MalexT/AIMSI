(ns aimsi.core
  (:require
   [spinner.core :as spin]
   [clipboardf.clipboard :as clipboard])
  (:gen-class))


(defn do-something []
  (Thread/sleep 500)
  (let [a "Aleksa Markovic"]
    a))

(defn print-usage []
  (println "\nUsage:\tEncrypting desired text:\n
    For example: -e -c key plaintext\n
Decrypting desired text:\n
    For example: -d -c key cipheredtext"))

(defn text-ciphered-copied-notification [text]
  (println "\n> Text ciphered and copied to clipboard")
  (println "Ciphered: " text))

(defn load-data-with-spinner [f]
  (let [s (spin/create-and-start!
           {:frames (:ascii-spinner spin/styles) :fg-colour :white})
        result (f)]
    (spin/stop! s)
    result))

(defn -main
  [& args]
  (let [arg-num (count args)]
    (cond
      (= arg-num 0) (print-usage)
      (= arg-num 1)
      (let [text (load-data-with-spinner do-something)]
        (clipboard/spit-clipboard (str arg-num))
        (text-ciphered-copied-notification text))
      :else (println "Invalid arguments passed"))))