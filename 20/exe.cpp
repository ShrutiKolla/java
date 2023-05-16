#include <iostream>
using namespace std;

int main() {
	int T,A,B,C;
	cin>>T;
	while(T) {
	    cin>>A>>B>>C;
        for(int K = 1 ; K < C + 1 ; K++) {
            if((A % K != 0) && (B % K != 0) && (C % K != 0)) {
                cout<<K;
                break;
            }
        }
	}
	return 0;
}
