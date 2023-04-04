public class Clock {

    private int hours;
    private int minutes;
    private int seconds;

    // constructor 1
    Clock(int hours, int minutes, int seconds){
        if(hours >= 0 && hours <= 23){
            this.hours = hours;
        } else {
            throw new IllegalArgumentException ("Bad hours, [ 0 - 23 ]");
        }
        if(minutes >= 0 && minutes <= 59){
            this.minutes = minutes;
        } else {
            throw new IllegalArgumentException ("Bad minutes, [ 0 - 59 ]");
        }
        if(seconds >= 0 && seconds <= 59){
            this.seconds = seconds;
        } else {
            throw new IllegalArgumentException ("Bad seconds, [ 0 - 59 ]");
        }
    }

    // constructor 2 - "12:00:00"
    Clock(){
        this.hours = 12;
        this.minutes = 0;
        this.seconds = 0;
    }

    // constructor 3
    Clock(int onlySeconds){
        this.hours = onlySeconds / 3600;
        this.minutes = (onlySeconds - (this.hours * 3600) ) / 60;
        this.seconds = (onlySeconds - (this.hours * 3600) - (this.minutes * 60));
    }

    public int getHours(){
        return this.hours;
    }
    public int getMinutes(){
        return this.minutes;
    }
    public int getSeconds(){
        return this.seconds;
    }

    public void setHours(int hours){
        if(hours >= 0 && hours <= 23){
            this.hours = hours;
        } else {
            throw new IllegalArgumentException ("Bad hours, [ 0 - 23 ]");
        }
    }

    public void setMinutes(int minutes){
        if(minutes >= 0 && minutes <= 59){
            this.minutes = minutes;
        } else {
            throw new IllegalArgumentException ("Bad minutes, [ 0 - 59 ]");
        }
    }

    public void setSeconds(int seconds){
        if(seconds >= 0 && seconds <= 59){
            this.seconds = seconds;
        } else {
            throw new IllegalArgumentException ("Bad seconds, [ 0 - 59 ]");
        }
    }

    public void tick(){
        if(this.seconds >= 0 && this.seconds <= 58){
            this.seconds += 1;
        } else {
            this.seconds = 0;
            if(this.minutes == 59){
                this.minutes = 0;
                if(this.hours == 23){
                    this.hours = 0;
                } else {
                    this.hours += 1;
                }
            } else {
                this.minutes += 1;
            }
        }
    }

    public void tickDown(){
        if(this.seconds >=1 && this.seconds <= 60){
            this.seconds -= 1;
        }else{
            this.seconds = 59;
            if(this.minutes == 0){
                this.minutes = 59;
                if(this.hours == 0){
                    this.hours = 23;
                } else {
                    this.hours -= 1;
                }
            } else {
                this.minutes -= 1;
            }
        }
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
    }

}