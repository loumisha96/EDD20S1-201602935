

#include <iostream>

using namespace std;

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
		return primero == 0;
	}
	//insertar al inicio
	void insertarPrimero(char letra) {
		nodo* nuevo = new nodo(letra);
		if (vacia()) {
			primero = nuevo;
			ultimo = nuevo;
			tam = 0;
		}
		else {
			primero->ant = nuevo;
			nuevo->sig = primero;
			primero = nuevo;
			tam++;
		}
	}
	void eliminarUltimo() {
		ultimo->ant->sig = 0;
		ultimo->ant = ultimo;
		ultimo->sig = 0;
		tam--;
	}
	int posinicio = -1;
	int posfinal = -1;
	nodo* buscar(string s, nodo*aux1, int cont) {
		bool var = true;
		nodo *aux = aux1;
		int cont1=cont;
		while (var) {
			for (auto x : s) {
				if (aux->letra == x) {
					cont1++;
					if (posinicio < 0)
						posinicio = cont1;
					if (aux->sig== 0 || aux->sig->letra == ' ')
						posfinal = cont1;
					aux = aux->sig;
				}
				else {
					while (aux->sig != 0) {
						if (aux->letra != ' ') {
							aux = aux->sig;
							cont1++;
						}
						else {
							aux = aux->sig;
							buscar(s, aux, cont1);
							break;
						}
					}
					if (aux->sig == 0) {
						var = false;
					}
				}
			}
			var = false;
			aux = primero;
			for (int i = 0; i < tam + 1; i++) {
				if (posinicio == i) {
					return aux;
				}
				else {
					if (aux->sig != 0)
						aux = aux->sig;
				}
			}
		}
	}
	void sd(string s, nodo* aux1, int cont) {
		
		nodo *s1 = buscar(s, aux1, cont);
		if (posinicio>= 0) {
			cout << "Valor encontrado: ";
			cout << s1->letra << endl;
		}
		else {
			cout << "No se encuentra coincidencia ";
		}
		
	}

	void print() {
		nodo* aux = primero;
		while (aux->sig != 0) {
			cout << aux->letra << endl;
			aux = aux->sig;
		}
		cout << aux->letra << endl;
		
	}
};
int main()
{
	Lista* lista = new Lista();
	lista->insertarPrimero('M');
	lista->insertarPrimero(' ');
	lista->insertarPrimero('A');
	lista->insertarPrimero('L');
	lista->insertarPrimero('O');
	lista->insertarPrimero('H');
	nodo* aux = lista->primero;
	int cont = -1;
	lista->sd("P", aux, cont);
	//lista->buscar("M", aux, cont);

	
	
}

