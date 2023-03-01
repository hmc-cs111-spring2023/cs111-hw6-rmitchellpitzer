package machines

import regex._
import dfa._
import machines._

// TODO: Add your code below

given Conversion[Char, RegularLanguage] = Character(_) 
given Conversion[String, RegularLanguage] = S2RLHelper(_)


def S2RLHelper(s:String): RegularLanguage = 
    if s.length() == 1 then Character(s.head)
    else Concat(Character(s.head), S2RLHelper(s.tail))


extension (regex1: RegularLanguage)
  def ||(regex2 :RegularLanguage) : RegularLanguage = 
    Union(regex1, regex2)
  def ~(regex2: RegularLanguage) : RegularLanguage = 
    Concat(regex1, regex2)
  def <*> : RegularLanguage = 
    Star(regex1)
  def <+> : RegularLanguage = 
    Concat(regex1, regex1 <*>)
  def apply(int: Int): RegularLanguage = 
    if int == 1 then regex1
    else Concat(regex1, regex1{int - 1})
  def toDFA(using alphabet: Set[Char]) = 
    regexToDFA(regex1, alphabet)




// Testing Compiling

val zero1 = '0'
val zero2 = '0'
val newRegex = '1'||'2'
val newRegex3 = newRegex<+>
val newRegex2 = zero1 || zero2
val starRegex = Character('1')<*>
val applyRegex = Character('1'){5}