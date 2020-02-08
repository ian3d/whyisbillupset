export class Reaction {
    id: string;
    reasonId: string;
    liked: boolean;
    date: Date;

    public constructor(init?:Partial<Reaction>) {
        Object.assign(this, init);
    }
}