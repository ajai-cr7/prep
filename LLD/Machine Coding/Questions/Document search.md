(FAQ in RazorPay)

Your organization has started a new tech blog with interesting tech stories and you’re responsible for designing and implementing
an in-memory search engine, supporting the search functionality on the blog content.

Requirements:
-----
It should be possible to create a dataset in the search engine. 
It should be possible to insert and delete documents in a given dataset. Each document is simply a piece of text.
It should be possible to search through documents for a search pattern in a given dataset. 
It should be possible to order the search results
Search Pattern: Initially search pattern would be sequence of words, but can be extensible for different search patterns:
  Sequence of words containing words
  Sequence of words containing words maintaining the order
  Sequence of words containing words maintaining the order in sequence(substring)
Ordering Logic: Initially ordering pattern would be latest published article, but can be extensible for different search patterns:
  Ordering can be recently published articles
  Ordering can be recently updated articles
  Ordering can be recently searched articles
  Ordering can be done based on Author.


Apple is 

Map -> key -> document_id
	value-> string text

Examples
--------------
Search term: apple 

Doc1: apple is a fruit 
Doc2: apple, apple come on!
Doc3: oranges are sour
Doc4: apple-pie is sweet

[Doc2, Doc1, Doc4] or [Doc2, Doc4, Doc1]


**Other Requirements :**

It should be possible to create a category in the search engine.
It should be possible to insert and delete documents in a given category.
It should be possible to search through documents for a search pattern in a given category.
It should be possible to sort the search results : Sorting based upon the lastUpdatedDate and createdAt

Approach: Gathered the requirements like:

no case sensitive
a document can belong to multiple categories
should the sorting be stable?
Let's say we search for python, and in the document if multiple documents have the python
then sort it on the basis of the occurrences i.e. Higher frequencey one should come at the top basically desc order
document content will be less than 2000



**Solution tips:**

- We can use inverted index for a full text search + use metadata db + use trie for prefix word search. 
(
The    -> Document 1
Quick  -> Document 2
Lazy   -> Document 1, Document 2
Later  -> Document 2, Document 3
Dog    -> Document 1, Document 2

Now, If We Want to Give All Results Based on typed prefix like 'LA' --> Its appearing in multiple keys in inverted index key. So, here 
I can use a trie on top of the full text key of inverted index.
)

- We can use strategy pattern for ordering or sorting(input : List of documentIds --> order it based in meta data like created by, createdAt,
last_updated_at etc). (Strategy is used when we have a class of algorithms and want to choose provided one at run time) (In factory pattern
we will choose a class based on some criteria (factory is for obejct creation and strategy is for object behaviour))
