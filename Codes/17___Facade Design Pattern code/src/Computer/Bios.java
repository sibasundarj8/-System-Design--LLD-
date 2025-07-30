package Computer;

public class Bios {
    private final CPU cpu;
    private final Memory memory;

    public Bios(CPU cpu, Memory memory) {
        this.cpu = cpu;
        this.memory = memory;
    }

    public void boot() {
        cpu.initialize();
        memory.selfTest();
    }
}
