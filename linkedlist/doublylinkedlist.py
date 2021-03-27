'''
Implementation of Doubly Linked List
'''

class Node:
    def __init__(self, val):
        self.val = val
        self.next = None
        self.previous =  None

class DoublyLinked:
    def insert(self, head, val) -> Node:
        if head == None:
            return Node(val)
        

        return 
