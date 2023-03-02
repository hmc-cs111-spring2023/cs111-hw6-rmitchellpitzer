# Reflection on implementing regular expressions of a DSL

## Which operators were easiest to implement and why?

> I think the operators ||, ~, <*>, <+> were pretty easy to implement. They were all pretty easy to implement because it was mostly review from hw5 and was calling funcitons written in that assignment.

## Which operators were most difficult to implement and why?

> The more difficult operators to implement were {n} as that was recursive/required knowledge of apply and could have been incorrect with the wrong base case returning Empty, and probably toDFA but I don't think that's an operator that's just extended in the same block.

## Comment on the design of this internal DSL

> I think it's really cool! It does require much more effort than writing functions to do what you want in a general purpose language, but the upside is that this can be much more readable/understandable at a glance. It also allows for flexibility in implementation and usability. This could be seen in the implementation of toDFA and implicitly converting to DFA, and the operators created as Union/Concat/Star are still available to use but these new operators ||, ~, <*> and <+> now quicker shorthand and can provide more functionality such as in the case for <+> and {n}.

Write a few brief paragraphs that discuss:

- What works about this design? (For example, what things seem easy and
  natural to say, using the DSL?)
- What doesn't work about this design? (For example, what things seem
  cumbersome to say?)
- Think of a syntactic change that might make the language better. How would
  you implement it _or_ what features of Scala would prevent you from
  implementing it? (You don't have to write code for this part. You could say
  "I would use extension to..." or "Scala's rules for valid
  identifiers prevent...")

> I think the language works for the most part! Most of the implicit conversion isn't visible to the user and isn't visible in the frontend so I think that helps in readability/understandability. I think while some of the operators like || and ~ might be easily understood, others like <***>, <+> and {n} might be more difficult to understand immediately when looking at them. However I know the * and + operators can't be uesd because that's for multiplication and addition, so instaed <*> and <+> are used. I also feel like toDFA might be a bit unintuitive to use, seeing that it isn't consistent in the styling of the previous operators. Something like <DFA> or <δ> might be fun to implement but then <δ> would not be possible to type on standard english character keyboards.


> I think some changes I'd want to make are probably more consistency in the operators, so || becomes <||>, apply could instead become <n> although I feel this might be very difficult to implement (this might actually be impossible come to think about it and might interfere/overlap with the less than operator).  
> I really liked this assignment though! Super fun way of showing how to write functions that can be used in DSL's and troubleshooting weird type problems!