"""
- Split line by words
- Any underscores within a word should be removed, so...
    - Split words by underscores
    - Rewrite underscores back for any empty strings in result
    - Iterate over elements in word_parts; ones that are preceded by a "normal" string should be capitalized.
"""

def camelize(s: str) -> str:
    res = []
    words = s.split(" ")

    for word in words:
        word_parts = word.split("_")
        word_result = ""
        for idx, el in enumerate(word_parts):
            # Add underscore
            if el == "":
                word_result += "_"
                continue

            # Add a word from the beginning of the string (it is not camel-cased)
            if idx == 0:
                word_result += el
                continue

            # Our word is preceded by another; capitalize id
            if len(word_parts[idx - 1]) > 0:
                word_result += el[0].upper()
                word_result += el[1:]
                continue

            # Base case: word is
            word_result += el

        res.append(word_result)

    return " ".join(res)


# Couple random cases
a = camelize("__variable_one__ _variable_two variable_three")
b = "__variableOne__ _variableTwo variableThree"
assert a == b, f"FAIL: \n{a}\n{b}"

a = camelize("__1ariable_one__ _variable_1wo variable_3hree")
b = "__1ariableOne__ _variable1wo variable3hree"
assert a == b, f"FAIL: \n{a}\n{b}"