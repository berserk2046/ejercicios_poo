import tkinter as tk
from tkinter import *

class vendedor:
    def __init__(self,nombre, apellidos, edad):
        self.nombre = nombre
        self.apellidos = apellidos
        self.edad = edad
        self.output = ""
        self.verify()

    def verify(self):
        if not (18 < self.edad < 120): raise ValueError("Valor para la edad invalido, recuerde que la edad debe de estar entre 18 y 120, no puede ser mayor o inferior.")
        elif self.nombre == "": raise ValueError("Nombre vacio, inserte su nombre.")
        elif self.apellidos == "": raise ValueError("Apellidos vacios, inserte sus apellidos.")

class ventana:
    def __init__(self):
        self.output = ""
        self.d1_win = tk.Tk()
        self.d1_win.protocol("WM_DELETE_WINDOW", self.d1_win.destroy);

        labeln = tk.Label(self.d1_win, text="Ingrese el nombre:")
        self.entryn = Entry(self.d1_win)
        labels = tk.Label(self.d1_win, text="Ingrese los apellidos:")
        self.entrys = Entry(self.d1_win)
        labele = tk.Label(self.d1_win, text="Ingrese la edad:")
        self.entrye = Entry(self.d1_win)
        button = Button(self.d1_win, text="Ingresar", command=self.d1_case)
        self.label = tk.Label(self.d1_win)

        labeln.grid(row=0, column=0)
        self.entryn.grid(row=0, column=1)
        labels.grid(row=1, column=0)
        self.entrys.grid(row=1, column=1)
        labele.grid(row=2, column=0)
        self.entrye.grid(row=2, column=1)
        button.grid(row=3, column=0)
        self.label.grid(row=4, column=0)
        self.d1_win.mainloop()

    def d1_case(self):
        n, s, e = self.entryn.get(), self.entrys.get(), self.entrye.get()
        try: e = int(e)
        except: self.output += "Ingrese una edad valida\n"
        try:
            p1 = vendedor(n,s,e)
        except ValueError as error:
            self.output += f"Error detectado: {error}\n"
        else:
            self.output += f"Se ha creado el usuario {n} {s} que tiene edad valida {e}\n"
        self.label.config(text=self.output)

if __name__ == "__main__":
    win = ventana()
