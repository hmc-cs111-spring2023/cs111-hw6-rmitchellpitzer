package machines

import regex._
import dfa._
import machines._

// TODO: Add your code below

given Conversion[Char, RegularLanguage] = Character(_) 
given Conversion[String, RegularLanguage] = S2RLHelper(_)


def S2RLHelper(s:String): RegularLanguage = 
    if s == "" then return Empty
    else return Concat(Character(s.head), S2RLHelper(s.tail))

// def ||(regex1:RegularLanguage, regex2: RegularLanguage): RegularLanguage =
//     Union(regex1, regex2)

implicit class Operators(regex1 :RegularLanguage) {
  def ||(regex2 :RegularLanguage) : RegularLanguage = 
    Union(regex1, regex2)
  def ~(regex2: RegularLanguage) : RegularLanguage = 
    Concat(regex1, regex2)
  def <*> : RegularLanguage = 
    Star(regex1)
  def apply(int: Int): RegularLanguage = 
    if int == 0 then Empty
    else Concat(regex1, regex1{int - 1})
}

implicit class OperatorsForString(regex1 :String) {
  def ||(regex2 :String) : RegularLanguage = 
    Union(S2RLHelper(regex1), S2RLHelper(regex2))
  def ~(regex2 :String) : RegularLanguage = 
    Concat(S2RLHelper(regex1), S2RLHelper(regex2))
  def <*> : RegularLanguage = 
    Star(S2RLHelper(regex1))
  def apply(int: Int): RegularLanguage = 
    if int == 0 then Empty
    else Concat(S2RLHelper(regex1), S2RLHelper(regex1){int - 1})
}

// implicit class OperatorsForChar(regex1 :Char) {
//   def ||(regex2 :Char) : RegularLanguage = 
//     Union(S2RLHelper(regex1), S2RLHelper(regex2))
//   def ~(regex2 :String) : RegularLanguage = 
//     Concat(S2RLHelper(regex1), S2RLHelper(regex2))
//   def <*> : RegularLanguage = 
//     Star(S2RLHelper(regex1))
//   def apply(int: Int): RegularLanguage = 
//     if int == 0 then Empty
//     else Concat(S2RLHelper(regex1), S2RLHelper(regex1){int - 1})
// }




  val zero1 = '0'
  val zero2 = '0'




val newRegex = "1"||"2"
val newRegex2 = zero1||zero2

val starRegex = Character('1')<*>
val applyRegex = Character('1'){5}