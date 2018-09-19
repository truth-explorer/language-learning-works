;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname |iterative summation|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(define (sum a b)
  (
   if (> a b)
      0
      (iter a b (- b a) (+ a 1))
      ))
(define (iter a b c d)
  (
   if (= c 0)
      a
      (iter (+ a d) b (- c 1) (+ d 1))
      ))
   
      