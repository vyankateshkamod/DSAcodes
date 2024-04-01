#include <iostream>
using namespace std ;
void selectionsort(int arr[] , int n){
    cout<<"Array before the the selection sort\n";
    for(int i=0;i<n;i++){
        cout<<"  "<<arr[i] ;
    }
        cout<<"\n\n";
    int min , temp ;
    for(int i=0 ; i<n-1 ; i++){
         min = i ;
        for(int j = i+1 ; j < n ; j++){
            if(arr[j] < arr[min]){
                min = j ;
            }
        }
        temp = arr[i] ;
        arr[i] = arr[min] ;
        arr[min] = temp ;
    }
    cout<<"sorted array \n" ;
    for(int i = 0 ; i < n ; i++){
        cout<<"  "<<arr[i] ;
    }
        cout<<"\n";
}
int main(){
    int n ;
    cout<<"Enter size of array : ";
    cin>>n ;
    int A[n] ;
    cout<<"Enter values one by one\n" ;
    for(int i = 0 ; i<n ; i++){
        cin>>A[i] ;
    }
    
    selectionsort(A,n);
    return 0 ;
}