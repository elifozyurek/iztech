import pandas as pd
import time
from sklearn.ensemble import RandomForestClassifier
from sklearn.svm import SVC
from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score
from sklearn.naive_bayes import MultinomialNB
from paperscraper.pubmed import get_pubmed_papers

"""
1- Creating the Dataset
"""

def collect_data(keywords):
    data = []

    for keyword in keywords:
        try:
            papers = get_pubmed_papers(keyword, max_results=500)
        except Exception as e:
            print(f"Error fetching papers for {keyword}: {e}")
            continue

        for a in range(len(papers)):
            try:
                if papers['title'][a] == None or papers['authors'][a] == None or papers['abstract'][a] == None:
                    continue

                paper_data = {
                    'Title': papers['title'][a],
                    'Authors': papers['authors'][a],
                    'Abstract': papers['abstract'][a],
                    "Label": keyword
                }

                data.append(paper_data)
            except Exception as e:
                print(
                    f"Error processing paper data for {keyword} (Index: {a}): {e}")

            time.sleep(0.0005)  # Add a delay between requests

    # Convert data to DataFrame
    df = pd.DataFrame(data)

    df.to_csv('dataset.csv', index=False)

search_query = ["brain injury", "type 2 diabetics", "kidney disease"]
collect_data(search_query)


excel_path = 'dataset.csv'
dataset = pd.read_csv(excel_path)

# Fill NaN values
dataset['Abstract'].fillna("", inplace=True)


print(dataset)
print("-----------------------------------------")

"""
2-  4 Classification Techniques
"""


X = dataset['Abstract']
y = dataset['Label']

# Split test/train set
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=45)

print("----vectorizing process for text data----")
time.sleep(2)

# Turn the text data into vectors using TfidfVectorizer
vectorizer = TfidfVectorizer(max_features=5000)
X_train_vec = vectorizer.fit_transform(X_train)
X_test_vec = vectorizer.transform(X_test)

"""
K-Nearest Neighbors Model
"""

print("-----------K-Nearest Neighbors-----------")
print("-------------------n=5-------------------")

time.sleep(2)
knn_model = KNeighborsClassifier()
knn_model.fit(X_train_vec, y_train)

# Prediction for test set
y_pred = knn_model.predict(X_test_vec)

# Evaluate the performance of KNN model
train_score = knn_model.score(X_train_vec, y_train)
test_score = knn_model.score(X_test_vec, y_test)
accuracy = accuracy_score(y_test, y_pred)

print("K-Neighbor Model Results:")
print("Train score:", round(train_score,4))
print("Test score:", round(test_score,4))
print("Accuracy:", round(accuracy,4)," \n") 

"""
Naive Bayes Model
""" 

print("---------------Naive Bayes---------------")
print("-------------------a=1-------------------")

time.sleep(2)
nb_model = MultinomialNB()
nb_model.fit(X_train_vec, y_train)

# Prediction for test set
y_pred_nb = nb_model.predict(X_test_vec)

# Evaluate the performance of Naive Bayes model
train_score = nb_model.score(X_train_vec, y_train)
test_score = nb_model.score(X_test_vec, y_test)
accuracy_nb = accuracy_score(y_test, y_pred_nb)

print("Naive Bayes Model Results:")
print("Train score:", round(train_score,4))
print("Test score:", round(test_score,4))
print("Accuracy:", round(accuracy_nb,4)," \n")  

"""
Random Forest Model
"""

print("--------------Random Forest--------------")
print("-------------------n=100-----------------")

time.sleep(2)
rf_model = RandomForestClassifier(n_estimators=100)
rf_model.fit(X_train_vec, y_train)

# Prediction for test set
y_pred_rf = rf_model.predict(X_test_vec)

# Evaluate the performance of Random Forest model
train_score = rf_model.score(X_train_vec, y_train)
test_score = rf_model.score(X_test_vec, y_test)
accuracy_rf = accuracy_score(y_test, y_pred_rf)

print("Random Forest Model Results:")
print("Train score:", round(train_score,4)) 
print("Test score:", round(test_score,4))
print("Accuracy:", round(accuracy_rf,4)," \n") 

"""
Support Vector Machine Model
"""

print("---------Support Vector Machine----------")
print("-------------------C=1-------------------")

time.sleep(2)
# Support Vector Classifier is used
svm_model = SVC()
svm_model.fit(X_train_vec, y_train)

# Prediction for test set
y_pred_svm = svm_model.predict(X_test_vec)

# Evaluate the performance of Support Vector Machine model
train_score = svm_model.score(X_train_vec, y_train)
test_score = svm_model.score(X_test_vec, y_test)
accuracy_svm = accuracy_score(y_test, y_pred_svm)

print("Support Vector Machine Model Results:")
print("Train score:", round(train_score,4))
print("Test score:", round(test_score,4))
print("Accuracy:", round(accuracy_svm,4)," \n") 



"""

3-
Parameters that are used while increasing the accuracy:
(Regularization parameters for each classification technique)

Naive Bayes : alpha parameter
K-Nearest Neighbor : n parameter
SVM : C parameter, poly/linear kernel
Random Forest: n estimators
"""

print("--------IMPROVING ACCURACY SCORES--------\n")

# Change n to see its effect on the accuracy of KNN model
print("-------------KNN (n changes)-------------\n")
print("--------------Test 1 -> n=1--------------")


time.sleep(2)
knn_model = KNeighborsClassifier(1)
knn_model.fit(X_train_vec, y_train)

y_pred = knn_model.predict(X_test_vec)

train_score = knn_model.score(X_train_vec, y_train)
test_score = knn_model.score(X_test_vec, y_test)
accuracy = accuracy_score(y_test, y_pred)
print("K-Nearest Neighbors Model Results:")
print("Train score:",round( train_score,4))
print("Test score:", round(test_score,4))
print("Accuracy:", round(accuracy,4)," \n")

print("--------------Test 2 -> n=10-------------")

time.sleep(2)
knn_model = KNeighborsClassifier(10)
knn_model.fit(X_train_vec, y_train)

y_pred = knn_model.predict(X_test_vec)

train_score = knn_model.score(X_train_vec, y_train)
test_score = knn_model.score(X_test_vec, y_test)
accuracy = accuracy_score(y_test, y_pred)

print("K-Nearest Neighbors Model Results:")
print("Train score:",round( train_score,4))
print("Test score:", round(test_score,4))
print("Accuracy:", round(accuracy,4)," \n")

print("--------------Test 3 -> n=30-------------")

time.sleep(2)
knn_model = KNeighborsClassifier(30)
knn_model.fit(X_train_vec, y_train)

y_pred = knn_model.predict(X_test_vec)

train_score = knn_model.score(X_train_vec, y_train)
test_score = knn_model.score(X_test_vec, y_test)
accuracy = accuracy_score(y_test, y_pred)

print("K-Nearest Neighbors Model Results:")
print("Train score:",round( train_score,4))
print("Test score:", round(test_score,4))
print("Accuracy:", round(accuracy,4)," \n")

# Change alpha (a) parameter to see its effect on the accuracy of Naive Bayes model
print("---------Naive Bayes (a changes)---------\n")
print("--------------Test 1 -> a=0.1------------")


time.sleep(2)

nb_model = MultinomialNB(alpha=0.1)
nb_model.fit(X_train_vec, y_train)

y_pred_nb = nb_model.predict(X_test_vec)

train_score = nb_model.score(X_train_vec, y_train)
test_score = nb_model.score(X_test_vec, y_test)
accuracy_nb = accuracy_score(y_test, y_pred_nb)

print("Naive Bayes Model Results:")
print("Train score:",round( train_score,4))
print("Test score:", round(test_score,4))
print("Accuracy:", round(accuracy_nb,4)," \n")

print("--------------Test 2 -> a=30-------------")

time.sleep(2)

nb_model = MultinomialNB(alpha=30)
nb_model.fit(X_train_vec, y_train)

y_pred_nb = nb_model.predict(X_test_vec)

train_score = nb_model.score(X_train_vec, y_train)
test_score = nb_model.score(X_test_vec, y_test)
accuracy_nb = accuracy_score(y_test, y_pred_nb)

print("Naive Bayes Model Results:")
print("Train score:",round( train_score,4))
print("Test score:", round(test_score,4))
print("Accuracy:", round(accuracy_nb,4)," \n")


# Change n to see its effect on the accuracy of Random Forest model
print("--------Random Forest (n changes)--------\n")
print("--------------Test 1 -> n=20-------------")

time.sleep(2)

rf_model = RandomForestClassifier(n_estimators=20)
rf_model.fit(X_train_vec, y_train)

y_pred_rf = rf_model.predict(X_test_vec)

train_score = rf_model.score(X_train_vec, y_train)
test_score = rf_model.score(X_test_vec, y_test)
accuracy_rf = accuracy_score(y_test, y_pred_rf)

print("Random Forest Model Results:")
print("Train score:",round( train_score,4))
print("Test score:", round(test_score,4))
print("Accuracy:", round(accuracy_rf,4)," \n")

print("--------------Test 2 -> n=150------------")

time.sleep(2)

rf_model = RandomForestClassifier(n_estimators=150)
rf_model.fit(X_train_vec, y_train)

y_pred_rf = rf_model.predict(X_test_vec)

train_score = rf_model.score(X_train_vec, y_train)
test_score = rf_model.score(X_test_vec, y_test)
accuracy_rf = accuracy_score(y_test, y_pred_rf)

print("Random Forest Model Results:")
print("Train score:",round( train_score,4))
print("Test score:", round(test_score,4))
print("Accuracy:", round(accuracy_rf,4)," \n")
# Change C to see its effect on the accuracy of SVM model
print("-------------SVM (C changes)-------------\n")
print("--------------Test 1 -> C=0.1------------")

time.sleep(2)

svm_model = SVC(C=0.1)
svm_model.fit(X_train_vec, y_train)

y_pred_svm = svm_model.predict(X_test_vec)

train_score = svm_model.score(X_train_vec, y_train)
test_score = svm_model.score(X_test_vec, y_test)
accuracy_svm = accuracy_score(y_test, y_pred_svm)

print("Support Vector Machine Model Results:")
print("Train score:",round( train_score,4))
print("Test score:", round(test_score,4))
print("Accuracy:", round(accuracy_svm,4)," \n")

print("--------------Test 2 -> C=20-------------")

time.sleep(2)

svm_model = SVC(C=20)
svm_model.fit(X_train_vec, y_train)

y_pred_svm = svm_model.predict(X_test_vec)

train_score = svm_model.score(X_train_vec, y_train)
test_score = svm_model.score(X_test_vec, y_test)
accuracy_svm = accuracy_score(y_test, y_pred_svm)

print("Support Vector Machine Model Results:")
print("Train score:",round( train_score,4))
print("Test score:", round(test_score,4))
print("Accuracy:", round(accuracy_svm,4)," \n")


# Change kernel to see its effect on the accuracy of SVM model
print("--------SVM (kernel changes, C=20)-------\n")
print("--------------kernel -> poly-------------")

time.sleep(2)

svm_model = SVC(C=20,kernel="poly")
svm_model.fit(X_train_vec, y_train)

y_pred_svm = svm_model.predict(X_test_vec)

train_score = svm_model.score(X_train_vec, y_train)
test_score = svm_model.score(X_test_vec, y_test)
accuracy_svm = accuracy_score(y_test, y_pred_svm)

print("Support Vector Machine Model Results:")
print("Train score:",round( train_score,4))
print("Test score:", round(test_score,4))
print("Accuracy:", round(accuracy_svm,4)," \n")

print("-------------kernel -> linear------------")

time.sleep(2)

svm_model = SVC(C=20,kernel="linear")
svm_model.fit(X_train_vec, y_train)

y_pred_svm = svm_model.predict(X_test_vec)

train_score = svm_model.score(X_train_vec, y_train)
test_score = svm_model.score(X_test_vec, y_test)
accuracy_svm = accuracy_score(y_test, y_pred_svm)

print("Support Vector Machine Model Results:")
print("Train score:",round( train_score,4))
print("Test score:", round(test_score,4))
print("Accuracy:", round(accuracy_svm,4)," \n")



