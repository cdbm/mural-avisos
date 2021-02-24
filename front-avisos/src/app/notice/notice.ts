export class Notice{
  id: number;
  title: string;
  description: string;
  createdAt: string;
  seenAt: string;

  constructor(title: string, description: string, createdAt: string, seenAt:string) {
    this.title = title;
    this.description = description;
    this.createdAt = createdAt;
    this.seenAt = seenAt;
  }
}
