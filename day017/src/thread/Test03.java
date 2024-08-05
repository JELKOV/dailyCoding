package thread;

abstract class Speaker {
    abstract String getName();
}

class RedSpeaker extends Speaker {
    @Override
    String getName() {
        return "빨간 스피커";
    }
}

class BlueSpeaker extends Speaker {
    @Override
    String getName() {
        return "파란 스피커";
    }
}

class Person123 {
    Speaker speaker;

    Person123(Speaker speaker) {
        this.speaker = speaker;
    }

    void turnOn() {
        System.out.println(speaker.getName() + "가 켜졌습니다.");
    }
}

public class Test03 {
    public static void main(String[] args) {
        Speaker s1 = new RedSpeaker();
        Person123 p1 = new Person123(s1);
        p1.turnOn();

        Speaker s2 = new BlueSpeaker();
        Person123 p2 = new Person123(s2);
        p2.turnOn();
    }
}
