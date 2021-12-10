(ns aimsi.core
  (:require
   [spinner.core :as spin]
   [clipboardf.clipboard :as clipboard]
   [rot.rot13 :as rot13])
  (:gen-class))


(defn print-usage []
  (println "\nUsage:\tEncrypting desired text:\n
    For example: -e -c key plaintext\n
Decrypting desired text:\n
    For example: -d -c key cipheredtext"))

(defn text-ciphered-copied-notification [text]
  (println "\n> Text ciphered and copied to clipboard")
  (println "Ciphered: " text))

(defn load-data-with-spinner [f text rotator]
  (let [s (spin/create-and-start!
           {:frames (:ascii-spinner spin/styles) :fg-colour :white})
        result (f text rotator)]
    (spin/stop! s)
    result))

(defn -main
  [& args]
  (let [arg-num (count args)]
    (cond
      (= arg-num 0) (print-usage)
      (= arg-num 1)
      (let [text (load-data-with-spinner rot13/rotate (str args) 13)]
        (clipboard/spit-clipboard text)
        (text-ciphered-copied-notification text))
      (= arg-num 2)
      (spit "Cipher.txt"  :append true)
      :else (println args))))