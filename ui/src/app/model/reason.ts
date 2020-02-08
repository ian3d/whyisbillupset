export class Reason {
    id: string;
    text: string;
    enteredOn: Date;

    public constructor(init?:Partial<Reason>) {
        Object.assign(this, init);
    }
}