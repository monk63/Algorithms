# Src = https://www.geeksforgeeks.org/python-get-a-list-as-input-from-user/
import math

import linecache

# Returns index of x in arr if present, else -1
def binarySearch(arr, l, r, x):
    while l<=r:
        m = math.ceil(((l+r)/2))
        if x==arr[m]:
            return m
        elif arr[l]<=arr[m]:
            if x>arr[m]:
                l=m+1
            elif x>=arr[l]:
                r=m-1
            else:
                l=m+1
        elif x<arr[m]:
            r=m-1
        elif x<arr[r]:
            l=m+1
        else:
            r=m-1
    return -1
             
#read from text file and store into array
text_file = open('input.txt', "r")
content=text_file.readlines()
content1=[elem.strip("\n").split() for elem in content]

casecount = int(content[0])
i=1
end=[]
while i<=casecount:
    
    arr=content1[(i*2)-1]
    x=content1[(i*2)][0] 
    result = binarySearch(arr, 0, len(arr)-1, x)
    
    if result != -1:
        end.append(str(result)+"\n")
            
    else:
            end.append("Item not present\n")
    i+=1
   
file = open('output.txt','w')
file.writelines(end)
file.close()





