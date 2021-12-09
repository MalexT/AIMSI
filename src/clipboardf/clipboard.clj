(ns clipboardf.clipboard)

(defn get-clipboard []
  (.getSystemClipboard (java.awt.Toolkit/getDefaultToolkit)))

(defn spit-clipboard [^String text]
  (.setContents (get-clipboard) (java.awt.datatransfer.StringSelection. text) nil))