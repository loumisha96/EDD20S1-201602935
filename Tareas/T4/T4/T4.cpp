

#include <iostream>

using namespace std;
int main()
{
    std::cout << "Hello World!\n"; 
}
class nodo {
public:
	char letra;
	nodo* sig;
	nodo* ant;

	nodo(char letra) {
		this->letra = letra;
		this->ant = 0;
		this->sig = 0;

	};
};
class Lista {
public:
	nodo* ultimo;
	nodo* primero;
	int tam;
	Lista() {
		this->ultimo = 0;
		this->primero = 0;
		
	}
	bool vacia() {
		primero = 0;
	}
	//insertar al inicio
	void insertar(char letra) {
		nodo* nuevo = new nodo(letra);
		if (vacia()) {
			primero = nuevo;
			ultimo = nuevo;
			tam = 0;
		}
		else {
			ultimo->sig = nuevo;
			nuevo->ant = ultimo;
			ultimo = nuevo;
			tam++;
		}
	}

};
