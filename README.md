# Word-Analysis-Backend
Word analysis to calculate word frequency and similar words when given a search key


# Task

To develop a Java REST API endpoint for finding the frequency of a given word and any similar
words in my lab notebook entry. A word is considered “similar” to another word if the Levenshtein distance is not more
than 1.

# Specification(s)

Given a basic notebook entry with the text “Word Words Wor word"
When the frequency of the word “Word” is requested
Then the frequency is determined to be `1`
And the list of similar words is determined to be “Words", "Wor", "word"
- Given a basic notebook entry with the text “Word Word Word word"
When the frequency of the word “Word” is requested
Then the frequency is determined to be `3`
And the list of similar words is determined to be “word"

# End points

URL : http://localhost:8080/word/get
Method : POST
Input : JSON Object 

# Sample Input :
{
	
	"inputDescription" : "car cars Car Cart Carm Calm Carts",
  "searchString" : "Car"
}	


# Sample Output: 
{
    "frequency": 1,
    "similarWords": [
        "car",
        "Carm",
        "Cart"
    ]}

