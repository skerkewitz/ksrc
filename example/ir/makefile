LLC  = "llc-8"
CFLAGS = "-march=wasm32 -filetype=obj"

WASM_LD = "wasm-ld-8"
LDFLAGS = "--no-entry --export-all --allow-undefined"

main: main.o
	$(WASM_LD) $(LDFLAGS) -o main.wasm main.o

main.o:
	$(LLC) $(CFLAGS) main.il -o main.o