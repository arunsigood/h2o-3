from __future__ import print_function
import sys
sys.path.insert(1,"../../../")
import h2o
from tests import pyunit_utils




def nb_prostate():
    

    print("Importing prostate.csv data...")
    prostate = h2o.upload_file(pyunit_utils.locate("smalldata/logreg/prostate.csv"))

    print("Converting CAPSULE, RACE, DCAPS, and DPROS to categorical")
    prostate['CAPSULE'] = prostate['CAPSULE'].asfactor()
    prostate['RACE'] = prostate['CAPSULE'].asfactor()
    prostate['DCAPS'] = prostate['DCAPS'].asfactor()
    prostate['DPROS'] = prostate['DPROS'].asfactor()

    print("Compare with Naive Bayes when x = 3:9, y = 2")
    prostate_nb = h2o.naive_bayes(x=prostate[2:9], y=prostate[1], laplace = 0)
    prostate_nb.show()

    print("Predict on training data")
    prostate_pred = prostate_nb.predict(prostate)
    prostate_pred.head()



if __name__ == "__main__":
    pyunit_utils.standalone_test(nb_prostate)
else:
    nb_prostate()