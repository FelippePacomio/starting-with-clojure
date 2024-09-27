; Partial EX01

(defn soma [a b] (+ a b))
(def soma10 (partial soma 10))
(println (soma10 50))

; Partial EX02

(defn converter-temp [m s t] (* (+ t s) m))
(def kelvin-para-celsius (partial converter-temp 1.0 -273.15))
(println (kelvin-para-celsius 250.0))
(println (kelvin-para-celsius 359.0))
(def farenheit-para-celsius
    (partial converter-temp (/ 5 9) -32))
(println (farenheit-para-celsius 80.0))

; Partial EX03

(defn calcular_preco [preco desconto]
  (* preco (- 1 desconto)))
(def desconto_10_porcento (partial calcular_preco 0.10))
(println "Valor do Desconto:" (desconto_10_porcento 1600))

; Partial EX04

(defn concatenar [c a b] (c a b))
(def saudacao (partial concatenar str))
(println (saudacao "Hello" "World"))

; Partial EX05

(defn calculadora-subtracao [f a b] (f a b))
(def subtracao (partial calculadora-subtracao -))
(println (subtracao 7 8))

(defn calculadora-soma [f a b] (f a b))
(def soma (partial calculadora-soma +))
(println (soma 7 8))

(defn calculadora-multiplicacao [f a b] (f a b))
(def multiplicacao (partial calculadora-multiplicacao *))
(println (multiplicacao 7 8))

(defn calculadora-divisao [f a b] (f a b))
(def divisao (partial calculadora-divisao /))
(println (divisao 7.0 8.0))

; Currying EX01

(defn soma [a] (fn [b] (+ a b)))
(println ((soma 5) 6))
(def soma5 (soma 5))
(println (soma5 6))

; Currying EX08

(defn texto [texto]
    (fn [operacao]    ;;fn = funcao anonima, nao precisa atribuir um nome a ela
        (case operacao
            "maiuscula" (clojure.string/upper-case texto)
            "inverte" (reverse texto)
            )))
(println ((texto "Oi, boa noite") "maiuscula"))
(println ((texto "Oi, boa noite") "inverte"))

; Curryng EX10

(defn gerar-relatorio [tipo]
  (fn [dados]
    (cond
      (= tipo "PDF") (str "Relatório em PDF: " dados)
      (= tipo "HTML") (str "<html><body>Relatório: " dados "</body></html>")
      (= tipo "CSV") (str "Relatório em CSV: " (clojure.string/join "," (map str dados)))
      :else "Tipo de relatório desconhecido.")))
(def gerar-pdf (gerar-relatorio "PDF"))
(def gerar-html (gerar-relatorio "HTML"))
(def gerar-csv (gerar-relatorio "CSV"))
(println (gerar-pdf "Dados do relatório"))  
(println (gerar-html "Dados do relatório"))  
(println (gerar-csv [1 2 3 4]))              