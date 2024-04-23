class Animal():
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def eat(self):
        print(self.name, " is eating...")

    def speak(self):
        print(self.name, " is speaking I'm ", self.age, " years old.")

class Tiger(Animal):
    pass

class Dog(Animal):
    def eatplus(self):
        print(self.name, " is eating bone")

if __name__ == '__main__':
    tiger = Animal("虎王", 3)
    tiger.eat()
    tiger.speak()

    dog = Dog("够王", 3)
    dog.eatplus()