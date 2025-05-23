package net.minecraft.world;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;

public class NextTickListEntry implements Comparable<NextTickListEntry>
{
    private static long nextTickEntryID;
    private final Block block;
    public final BlockPos position;
    public long scheduledTime;
    public int priority;
    private final long tickEntryID;

    public NextTickListEntry(BlockPos positionIn, Block blockIn)
    {
        this.tickEntryID = nextTickEntryID++;
        this.position = positionIn;
        this.block = blockIn;
    }

    public boolean equals(Object p_equals_1_)
    {
        if (!(p_equals_1_ instanceof NextTickListEntry nextticklistentry))
        {
            return false;
        }
        else
        {
            return this.position.equals(nextticklistentry.position) && Block.isEqualTo(this.block, nextticklistentry.block);
        }
    }

    public int hashCode()
    {
        return this.position.hashCode();
    }

    public NextTickListEntry setScheduledTime(long scheduledTimeIn)
    {
        this.scheduledTime = scheduledTimeIn;
        return this;
    }

    public void setPriority(int priorityIn)
    {
        this.priority = priorityIn;
    }

    public int compareTo(NextTickListEntry p_compareTo_1_)
    {
        return this.scheduledTime < p_compareTo_1_.scheduledTime ? -1 : (this.scheduledTime > p_compareTo_1_.scheduledTime ? 1 : (this.priority != p_compareTo_1_.priority ? this.priority - p_compareTo_1_.priority : (Long.compare(this.tickEntryID, p_compareTo_1_.tickEntryID))));
    }

    public String toString()
    {
        return Block.getIdFromBlock(this.block) + ": " + this.position + ", " + this.scheduledTime + ", " + this.priority + ", " + this.tickEntryID;
    }

    public Block getBlock()
    {
        return this.block;
    }
}
