import tkinter as tk
from tkinter import *

class ventana:
    def __init__(self):
        self.root = tk.Tk()
        self.root.title("Selection")
        self.root.protocol("WM_DELETE_WINDOW", self.cerrar_ventana);
        self.buttond1 = tk.Button(self.root, text="Caso 1 (Division)", command=self.d1)
        self.buttond1.grid(row=0,column=0)
        self.root.mainloop()

    def d1(self):
        self.d1_window = Toplevel(self.root)
        self.d1_window.title("Division")
        self.labelc = tk.Label(self.d1_window, text="Cociente:")
        self.cociente = Entry(self.d1_window)
        self.labeln = tk.Label(self.d1_window, text="Numerador:")
        self.numerador = Entry(self.d1_window)
        self.button = Button(self.d1_window, text="Submit", command=self.d1_case)
        self.label = tk.Label(self.d1_window)

        self.label.grid(row=3,column=0)
        self.labeln.grid(row=0, column=0)
        self.numerador.grid(row=0, column=1)
        self.labelc.grid(row=1, column=0)
        self.cociente.grid(row=1, column=1)
        self.button.grid(row=2, column=0)

    def d1_case(self):
        c, n = self.cociente.get(), self.numerador.get()
        output = ""

        try:
            c = int(c)
            n = int(n)
        except ValueError: c, n = 0,0

        try:
            output += "Ingresando el primer try\n"
            n = n/c
            output += "Despues de la division\n"
        except ZeroDivisionError: output += "Division por cero\n"
        finally: output += "Ingresando el primer finally\n"
        try:
            output += "Ingresando el segundo try\n"
            objeto = None
            str(objeto)
        except ZeroDivisionError: output ++ "Division por cero\n"
        except: output += "Ocurrio una excepcion\n"
        finally: output += "Ingresando el segundo finally\n"
        self.label.config(text=output)

    def cerrar_ventana(self):
        self.root.destroy()

if __name__ == "__main__":
    win = ventana()


