package machines
// Import statements
import regex._
import dfa._
import machines._


// Implicit Conversion for:
// char -> RegularLanguage, String -> RegularLanguage,
// RegularLanguage -> DFA
given Conversion[Char, RegularLanguage] = Character(_) 
given Conversion[String, RegularLanguage] = S2RLHelper(_)
given Conversion[RegularLanguage, DFA] = RL2DFAHelper(_)


// Helper function to convert a string to a Regular Language
def S2RLHelper(s:String): RegularLanguage = 
    if s.length() == 1 then Character(s.head)
    else Concat(Character(s.head), S2RLHelper(s.tail))

// Helper function to convert a RegularLanguage to a DFA
def RL2DFAHelper(regex:RegularLanguage): machines.dfa.DFA =
  return regexToDFA(regex, RL2CharSet(regex))

// Helper function to convert a Regular Expression to a Char set
def RL2CharSet(regex:RegularLanguage): Set[Char] = 
  regex match {
    case Empty => Set.empty
    case Epsilon => Set.empty
    case Character(c) => Set(c)
    case Union(regex1, regex2) => RL2CharSet(regex1) ++ RL2CharSet(regex2)
    case Concat(regex1, regex2) => RL2CharSet(regex1) ++ RL2CharSet(regex2)
    case Star(regex) => RL2CharSet(regex)
  } 


// Operators for ||, ~, <*>, <+>, {n}, toDFA
extension (regex1: RegularLanguage)
  def ||(regex2 :RegularLanguage) : RegularLanguage = Union(regex1, regex2)
  def ~(regex2: RegularLanguage) : RegularLanguage = Concat(regex1, regex2)
  def <*> : RegularLanguage = Star(regex1)
  def <+> : RegularLanguage = Concat(regex1, regex1 <*>)
  def apply(int: Int): RegularLanguage = 
    if int == 1 then regex1
    else Concat(regex1, regex1{int - 1})
  def toDFA(using alphabet: Set[Char]) = regexToDFA(regex1, alphabet)
