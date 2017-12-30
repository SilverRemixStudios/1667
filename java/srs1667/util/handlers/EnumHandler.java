package srs1667.util.handlers;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;

public class EnumHandler 
{
	//Enumerator for Ores
	public static enum EnumType implements IStringSerializable
	{
		COPPER(0, "copper"),
		SILVER(1, "silver");
		//Add more Ores here, list and put comma after each
		//up to 16 Ores
		
		private static final EnumType[] META_LOOKUP = new EnumType[values().length];
		private final int meta;
		private final String name, unlocaliszedName;
		
		private EnumType(int meta,String name)
		{
			this(meta, name, name);
		}
		
		private EnumType(int meta, String name, String unlocalizedName)
		{
			this.meta = meta;
			this.name = name;
			this.unlocaliszedName = unlocalizedName;
		}
		
		
		
		@Override
		public String getName()
		{
			return this.name;
		}
		
		public int getMeta()
		{
			return this.meta;
		}
		
		public String getUnlocalizedName()
		{
			return this.unlocaliszedName;
		}
		
		@Override
		public String toString()
		{
			return this.name;
		}
		
		public static EnumType byMetadata(int meta)
		{
			return META_LOOKUP[meta];
		}
		
		static
		{
			for(EnumType enumtype : values())
			{
				META_LOOKUP[enumtype.getMeta()] = enumtype;
			}
		}
	}
	
	
	//ENUM FOR LOG DIRECTIONS
	public static enum EnumLogAxis implements IStringSerializable
    {
        Z(0, "Z"),
        X(1, "X"),
        Y(2, "Y");

        private static final EnumLogAxis[] META_LOOKUP_LOGAXIS = new EnumLogAxis[values().length];
        private final int meta;
        private final String name, unlocalizedName;

        private EnumLogAxis(int meta, String name)
        {
            this(meta, name.toLowerCase(), name.toLowerCase());
        }

        private EnumLogAxis(int meta, String name, String unlocalizedname)
        {
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = unlocalizedname;
        }

        @Override
        public String getName()
        {
            return this.name().toLowerCase();
        }

        public int getMeta()
        {
            return this.meta;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName.toLowerCase();
        }

        public static EnumLogAxis fromFacingAxis(EnumFacing.Axis axis)
        {
            switch (axis)
            {
                case X:
                    return X;
                case Y:
                    return Y;
                case Z:
                    return Z;
                default:
                    return Y;
            }
        }

        @Override
        public String toString()
        {
            return this.name;
        }

        public static EnumLogAxis byMetadata(int meta)
        {
            return META_LOOKUP_LOGAXIS[meta];
        }

        static
        {
            for(EnumLogAxis enumtype : values())
            {
                META_LOOKUP_LOGAXIS[enumtype.getMeta()] = enumtype;
            }
        }
    }
	
	
	//Enumerator for Woods
	public static enum EnumWoodType implements IStringSerializable
	{
		REDWOOD(0, "redwood"),
		MAPLE(1, "maple"),
		BEECH(2, "beech"),
		WALNUT(3, "walnut");
		//Add more woods here, list and put comma after each
		//up to 16 Woods
		
		private static final EnumWoodType[] META_LOOKUP = new EnumWoodType[values().length];
		private final int meta;
		private final String name, unlocaliszedName;
		
		private EnumWoodType(int meta,String name)
		{
			this(meta, name, name);
		}
		
		private EnumWoodType(int meta, String name, String unlocalizedName)
		{
			this.meta = meta;
			this.name = name;
			this.unlocaliszedName = unlocalizedName;
		}
		
		
		
		@Override
		public String getName()
		{
			return this.name;
		}
		
		public int getMeta()
		{
			return this.meta;
		}
		
		public String getUnlocalizedName()
		{
			return this.unlocaliszedName;
		}
		
		@Override
		public String toString()
		{
			return this.name;
		}
		
		public static EnumWoodType byMetadata(int meta)
		{
			return META_LOOKUP[meta];
		}
		
		static
		{
			for(EnumWoodType enumWoodtype : values())
			{
				META_LOOKUP[enumWoodtype.getMeta()] = enumWoodtype;
			}
		}
	}
}
